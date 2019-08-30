package com.whitecloak.training.javafp;

import com.whitecloak.training.models.ItemModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * @author Jeremy Salve
 */

public class PrintTotalSalesIn2016 {

    public static void main(String[] args) throws IOException {

        Path pathManila = Paths.get("data_csv/manila.csv");
        Path pathCebu = Paths.get("data_csv/cebu.csv");
        Path pathDavao = Paths.get("data_csv/davao.csv");

        System.out.println("Print the total sales from all branches for the year 2016");
        printTotalSales2016(pathManila, pathCebu, pathDavao);
    }

    private static void printTotalSales2016(Path pathManila, Path pathCebu, Path pathDavao) throws IOException {

        Stream<String> itemStream = Stream.concat(Files.lines(pathManila), Files.lines(pathCebu));
        itemStream = Stream.concat(itemStream, Files.lines(pathDavao));

        BigDecimal totalSales = itemStream.filter(line -> !line.isBlank())
                .map(itemString -> itemString.split(","))
                .map(itemStringArray -> new ItemModel(itemStringArray[0], LocalDate.parse(itemStringArray[1], DateTimeFormatter.ofPattern("M/d/yyyy")), Integer.parseInt(itemStringArray[2]), new BigDecimal(itemStringArray[3])))
                .filter(itemModel -> itemModel.getDate().toString().contains("2016"))
                .map(itemModel -> itemModel.getPrice().multiply(BigDecimal.valueOf(itemModel.getUnitsSold())))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);

        System.out.println("Total Sales for All Branches in 2016: " + totalSales);
    }
}