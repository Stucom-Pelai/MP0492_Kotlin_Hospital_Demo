package com.geekymusketeers.medify.utils

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.Calendar

object DateTimeExtension {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentDateAsString(): String {
        return SimpleDateFormat(Constants.dateFormat, Locale.getDefault()).format(Date())
    }

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentDate(): Date? {
        val currentDateTime = LocalDateTime.now()
        val format = SimpleDateFormat(Constants.dateFormat)
        val formatter = DateTimeFormatter.ofPattern(Constants.dateFormat)
        val formattedDateTime = currentDateTime.format(formatter)
        return format.parse(formattedDateTime)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateAge(dateOfBirth: Date): Int {
        /*val period = Period.between(dateOfBirth, LocalDate.now())
        return period.years*/
        val currentDate = Date()  // Fecha actual
        val calendar = Calendar.getInstance()

        calendar.time = dateOfBirth  // Establecer la fecha de nacimiento en el calendario
        val birthYear = calendar.get(Calendar.YEAR)  // Obtener el año de nacimiento
        val birthMonth = calendar.get(Calendar.MONTH)  // Obtener el mes de nacimiento
        val birthDay = calendar.get(Calendar.DAY_OF_MONTH)  // Obtener el día de nacimiento

        calendar.time = currentDate  // Establecer la fecha actual en el calendario
        val currentYear = calendar.get(Calendar.YEAR)  // Obtener el año actual
        val currentMonth = calendar.get(Calendar.MONTH)  // Obtener el mes actual
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)  // Obtener el día actual

        // Calcular la diferencia en años
        var age = currentYear - birthYear

        // Si no hemos llegado al cumpleaños de este año, restamos un año
        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
            age--
        }

        return age  // Retornar la edad en años
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertDateToLocalDate(date: Date): Date {
        return date
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun String.convertTimestampToDateTime(): String {
        val timestampLong = this.toLongOrNull() ?: return "" // Return empty string if parsing fails
        val instant = Instant.ofEpochMilli(timestampLong)
        val dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm", Locale.getDefault())
        return dateTime.format(formatter)
    }

    fun getTimeStamp(): String {
        return System.currentTimeMillis().toString()
    }
}