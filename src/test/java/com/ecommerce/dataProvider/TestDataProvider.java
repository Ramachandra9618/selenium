package com.ecommerce.dataProvider;

import com.ecommerce.utitlity.ExcelUtility;
import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TestDataProvider {

    public static Stream<Arguments> productDataProvider(String filePath, String sheetName) throws IOException {
        List<Map> excelData = ExcelUtility.loadExcelData(filePath, sheetName);
        System.out.println(
                excelData
        );
        return excelData.stream().map(Arguments::of);
    }

}
