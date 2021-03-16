package com.travelers.helpers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
//Tworzenie klasy excel helper odczytującej dane z pliku .xlsx
public class ExcelHelper {
    //Metoda zwraca tablicę dwuwymiarową do wykorzystania w dataProviderze
    public static Object[][] readExcelFile(File file) throws IOException {
        //Podanie ścieżki do pliku .xlsx
        InputStream inputStream = new FileInputStream(file);
        //Użycie metody XSSFWorkbook do odczytu pliku
        //Dla plików xls - HSSFWorkbook
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        //Pobranie danych z arkusza o indeksie 0
        Sheet sheet = workbook.getSheetAt(0);
        int rowNumbers = sheet.getLastRowNum();
        int colNumbers = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rowNumbers][9];

        for(int i=0; i < rowNumbers; i++) {
            Row row = sheet.getRow(i+1);
            for(int j=0; j < row.getLastCellNum(); j++) {
                data[i][j] = row.getCell(j).getStringCellValue();
            }
        }
        return data;

        /*Iterator<Row> iterator = sheet.rowIterator();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(cell.getCellType().equals(CellType.STRING)) {
                    System.out.println(cell.getStringCellValue());
                } else if(cell.getCellType().equals(CellType.NUMERIC)) {
                    System.out.println(cell.getNumericCellValue());
                } else if(cell.getCellType().equals(CellType.ERROR)) {
                    System.out.println(cell.getErrorCellValue());
                }
            }
        }*/
    }
//      Sprawdzenie czy dane są odczytywane poprawnie

    /*public static void main(String[] args) throws IOException {
        Object[][] data = readExcelFile(new File("src/main/resources/Dane.xlsx"));
        System.out.println(data[0][9]);
        System.out.println();
    }*/


}
