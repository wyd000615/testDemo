package com.other;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;


/**
 * @Description : TODO导入excel
 * @date : Mar 31, 2018 5:17:14 PM
 */

public class File2Demo {

    public static void main(String args[]) {

        File2Demo excelImport = new File2Demo();

        try {

            excelImport.importExcelAction();

        } catch (Exception e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

    }

    //导入Excel数据

    public void importExcelAction() throws Exception {

//文件路径

        String filePath = "C:/Users/79056/Desktop/资费叠加20200925/模组叠加订购产品配置梳理文档.xlsx";

        XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));

        XSSFSheet sheet = wookbook.getSheet("Sheet1");

        //获取到Excel文件中的所有行数

        int rows = sheet.getPhysicalNumberOfRows();

        //遍历行

        List<PKPEENTITy> list = new ArrayList<PKPEENTITy>();

        for (int i = 1; i < rows; i++) {

            // 读取左上端单元格

            XSSFRow row = sheet.getRow(i);

            // 行不为空

            if (row != null) {

                Map<String, Object> map = new HashMap<String, Object>();

                //获取到Excel文件中的所有的列

                int cells = row.getPhysicalNumberOfCells();

                //pk

                XSSFCell nameCell = row.getCell(2);

                String pk = getValue(nameCell);

                //pe

                XSSFCell sexCell = row.getCell(3);

                String pe = getValue(sexCell);

                //是否可叠加

                XSSFCell ageCell = row.getCell(5);

                String order = getValue(ageCell);

                //是否允许退订

                XSSFCell birthCell = row.getCell(6);
                String unsubscribe = getValue(birthCell);
                PKPEENTITy pkpeentiTy = new PKPEENTITy();
                pkpeentiTy.setPk(pk);
                pkpeentiTy.setPe(pe);
                pkpeentiTy.setOrder(order);
                pkpeentiTy.setUnsubscribe(unsubscribe);

                list.add(pkpeentiTy);

            }

        }

        //System.out.println("list = " + JSON.toJSONString(list));
        String context ="";
        for (int i = 0; i < list.size(); i++) {
            PKPEENTITy pkpeentiTy  = list.get(i);
            String pk =pkpeentiTy.getPk();
            String pe= pkpeentiTy.getPe();
            String  order =pkpeentiTy.getOrder();
            if("是".equals(order)){
                order="1";
            }else{
                order="0";
            }

            String unsubscribe = pkpeentiTy.getUnsubscribe();
            if("是".equals(unsubscribe)){
                unsubscribe="1";
            }else{
                unsubscribe="0";
            }
            System.out.println(list.get(i));
            String str = "update dbvop.pkg_element pe set pe.double_order = '";
            String str1 = "' ,pe.allow_unsubscribe ='";
            String str2 = "' where pe.pkg_element_id='";
            String str3 = "' and pe.prod_package_id='";
            String str4 ="' ;";
            String str5="";

            String strAll = str+order + str1 + unsubscribe+str2+pe+str3+pk+str4+str5;
            //System.out.println(strAll);
            context+=strAll;

        }
        writeFile(context);

    }
    private void writeFile(String content) throws IOException {
        //String content = "A cat will append to the end of the file";

        File file =new File("C:/Users/79056/Desktop/资费叠加20200925/sql/test/test_appendfile"+new Date().getTime()+".txt");

        if(!file.exists()){
            file.createNewFile();
        }

        //使用true，即进行append file

        FileWriter fileWritter = new FileWriter(file.getName(),true);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes());

        fileOutputStream.close();



    }
    private String getValue(XSSFCell xSSFCell) {

        if (null == xSSFCell) {

            return "";

        }

        if (xSSFCell.getCellType() == xSSFCell.CELL_TYPE_BOOLEAN) {

            // 返回布尔类型的值

            return String.valueOf(xSSFCell.getBooleanCellValue());

        } else if (xSSFCell.getCellType() == xSSFCell.CELL_TYPE_NUMERIC) {

            // 返回数值类型的值

            return String.valueOf(xSSFCell.getNumericCellValue());

        } else {

            // 返回字符串类型的值

            return String.valueOf(xSSFCell.getStringCellValue());

        }

    }
}