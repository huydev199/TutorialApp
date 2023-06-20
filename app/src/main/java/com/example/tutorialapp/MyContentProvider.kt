package com.example.tutorialapp

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri


class MyContentProvider: ContentProvider() {
    companion object {
        const val AUTHORITY = "com.example.studentprovider.provider.StudentProvider"
        const val BASE_PATH = "students"

        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/$BASE_PATH")

        // Các trường trong bảng student
        const val KEY_ID = "_id"
        const val KEY_NAME = "name"
        const val KEY_GRADE = "grade"

        private const val STUDENTS = 1
        private const val STUDENT_ID = 2

        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

        init {
            uriMatcher.addURI(AUTHORITY, BASE_PATH, STUDENTS)
            uriMatcher.addURI(AUTHORITY, "$BASE_PATH/#", STUDENT_ID)
        }
    }

    private lateinit var database: SQLiteDatabase

    // Khởi tạo provider
    override fun onCreate(): Boolean {
        val context = context ?: return false
        val dbHelper = DatabaseHelper(context)
        database = dbHelper.writableDatabase
        return true
    }

    // Truy vấn bảng student
    override fun query(uri: Uri, projection: Array<String>?, selection: String?,
                       selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        val queryBuilder = SQLiteQueryBuilder()
        queryBuilder.tables = DatabaseHelper.TABLE_STUDENTS

        val uriType = uriMatcher.match(uri)
        when (uriType) {
            STUDENTS -> { }
            STUDENT_ID -> queryBuilder.appendWhere("$KEY_ID=${uri.lastPathSegment}")
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }

        val cursor = queryBuilder.query(database, projection, selection,
            selectionArgs, null, null, sortOrder)
        cursor.setNotificationUri(context!!.contentResolver, uri)

        return cursor
    }

    // Lấy loại MIME của Uri
    override fun getType(uri: Uri): String? {
        return null
    }

    // Thêm mới một student vào bảng student
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val id = database.insert(DatabaseHelper.TABLE_STUDENTS, null, values)
        context?.contentResolver?.notifyChange(uri, null)
        return Uri.parse("$BASE_PATH/$id")
    }

    // Cập nhật thông tin của một student
    override fun update(uri: Uri, values: ContentValues?, selection: String?,
                        selectionArgs: Array<String>?): Int {
        val rowsUpdated = database.update(DatabaseHelper.TABLE_STUDENTS, values,
            selection, selectionArgs)
        context?.contentResolver?.notifyChange(uri, null)
        return rowsUpdated
    }

    // Xóa một student khỏi bảng student
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val rowsDeleted = database.delete(DatabaseHelper.TABLE_STUDENTS, selection,
            selectionArgs)
        context?.contentResolver?.notifyChange(uri, null)
        return rowsDeleted
    }

    private class DatabaseHelper(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        companion object {
            private const val DATABASE_NAME = "students.db"
            private const val DATABASE_VERSION = 1

            const val TABLE_STUDENTS = "students"

            private const val CREATE_TABLE_STUDENTS = "CREATE TABLE $TABLE_STUDENTS (" +
                    "$KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$KEY_NAME TEXT," +
                    "$KEY_GRADE TEXT" +
                    ")"
        }

        override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL(CREATE_TABLE_STUDENTS)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENTS")
            onCreate(db)
        }
    }
}