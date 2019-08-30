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

public class PrintTotalSales {

    public static void main(String[] args) throws IOException {

        Path pathManila = Paths.get("data_csv/manila.csv");
        Path pathCebu = Paths.get("data_csv/cebu.csv");
        Path pathDavao = Paths.get("data_csv/davao.csv");

        System.out.println("Print the total sales from all branches");
        printTotalSales(pathManila, pathCebu, pathDavao);
    }

    private static void printTotalSales(Path pathManila, Path pathCebu, Path pathDavao) throws IOException {

        Stream<String> itemStream = Stream.concat(Files.lines(pathManila), Files.lines(pathCebu));
        itemStream = Stream.concat(itemStream, Files.lines(pathDavao));

        BigDecimal totalSales = itemStream.filter(line -> !line.isBlank())
                .map(itemString -> itemString.split(","))
                .map(itemStringArray -> new ItemModel(itemStringArray[0], LocalDate.parse(itemStringArray[1], DateTimeFormatter.ofPattern("M/d/yyyy")), Integer.parseInt(itemStringArray[2]), new BigDecimal(itemStringArray[3])))
                .map(itemModel -> itemModel.getPrice().multiply(BigDecimal.valueOf(itemModel.getUnitsSold())))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);

        System.out.println("Total Sales for All Branches: " + totalSales);
    }
}