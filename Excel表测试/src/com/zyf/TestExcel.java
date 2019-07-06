package com.zyf;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TestExcel {
       //记录类的输出信息­
       static Log log = LogFactory.getLog(TestExcel.class); 
       //获取Excel文档的路径­
       public static String filePath = "D://excel.xls";
       public static void main(String[] args) {
             try {
                   // 创建对Excel工作簿文件的引用­
                   HSSFWorkbook wookbook = new HSSFWorkbook(new FileInputStream(filePath));
                   // 在Excel文档中，第一张工作表的缺省索引是0
                   // 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);­
                   HSSFSheet sheet = wookbook.getSheet("Sheet1");
                   //获取到Excel文件中的所有行数­
                   int rows = sheet.getPhysicalNumberOfRows();
                   //遍历行­
                   for (int i = 0; i < rows; i++) {
                         // 读取左上端单元格­
                         HSSFRow row = sheet.getRow(i);
                         // 行不为空­
                         if (row != null) {
                               //获取到Excel文件中的所有的列­
                               int cells = row.getPhysicalNumberOfCells();
                               String value = "";     
                               //遍历列­
                               for (int j = 0; j < cells; j++) {
                                     //获取到列的值­
                                     HSSFCell cell = row.getCell(j);
                                     if (cell != null) {
                                           switch (cell.getCellType()) {
                                                 case HSSFCell.CELL_TYPE_FORMULA:
                                                 break;
                                                 case HSSFCell.CELL_TYPE_NUMERIC:
                                                       value += cell.getNumericCellValue() + ",";        
                                                 break;  
                                                 case HSSFCell.CELL_TYPE_STRING:
                                                       value += cell.getStringCellValue() + ",";
                                                 break;
                                                 default:
                                                       value += "0";
                                                 break;
                                     }
                               }      
                         }
                         // 将数据插入到mysql数据库中­
                         String[] val = value.split(",");
                         TestEntity entity = new TestEntity();
                         entity.setNum1(val[0]);
                         entity.setNum2(val[1]);
                         entity.setNum3(val[2]);
                         entity.setNum4(val[3]);
                         entity.setNum5(val[4]);
                         entity.setNum6(val[5]);
                         TestMethod method = new TestMethod();
                         method.Add(entity);
                   }
              }
       } catch (FileNotFoundException e) {
             e.printStackTrace();
       } catch (IOException e) {
             e.printStackTrace();
       }
    }
 }