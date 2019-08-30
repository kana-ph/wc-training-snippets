package com.whitecloak.training.javafp;

import com.whitecloak.training.models.ItemModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Jeremy Salve
 */

public class PrintBranchTotalSales {

    public static void main(String[] args) throws IOException {

        Path pathManila = Paths.get("data_csv/manila.csv");
        Path pathCebu = Paths.get("data_csv/cebu.csv");
        Path pathDavao = Paths.get("data_csv/davao.csv");

        System.out.println("Print the total sales of each branches");
        printBranchTotalSales(pathManila, pathCebu, pathDavao);
    }

    private static void printBranchTotalSales(Path pathManila, Path pathCebu, Path pathDavao) throws IOException {

        Stream<List> itemStream = Stream.of(
                List.of("Manila", getTotalSales(pathManila)),
                List.of("Cebu", getTotalSales(pathCebu)),
                List.of("Davao", getTotalSales(pathDavao))
        );

        itemStream.forEach(totalSales -> System.out.println("Total Sales for " + totalSales.get(0) + ": " + totalSales.get(1)));
    }

    private static BigDecimal getTotalSales(Path path) throws IOException {

        return Files.lines(path).filter(line -> !line.isBlank())
                .map(itemString -> itemString.split(","))
                .map(itemStringArray -> new ItemModel(itemStringArray[0], LocalDate.parse(itemStringArray[1], DateTimeFormatter.ofPattern("M/d/yyyy")), Integer.parseInt(itemStringArray[2]), new BigDecimal(itemStringArray[3])))
                .map(itemModel -> itemModel.getPrice().multiply(BigDecimal.valueOf(itemModel.getUnitsSold())))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }
}