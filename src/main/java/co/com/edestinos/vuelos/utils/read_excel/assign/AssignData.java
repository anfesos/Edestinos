package co.com.edestinos.vuelos.utils.read_excel.assign;

import co.com.edestinos.vuelos.utils.read_excel.AssignValueAttributesClass;
import org.apache.poi.ss.usermodel.Row;

import static co.com.edestinos.vuelos.utils.read_excel.AssignCellValueExcelFile.assignCellValueExcelFile;
import static co.com.edestinos.vuelos.utils.read_excel.read.ReadExcel.getListDataHead;
import static co.com.edestinos.vuelos.utils.static_information.StaticInformation.EXCEPTION_CONSTRUCTOR_EMPTY;

public class AssignData {
    private AssignData() {
        throw new IllegalStateException(EXCEPTION_CONSTRUCTOR_EMPTY);
    }

    public static void assignData(Row fila, Object datos) throws IllegalAccessException {
        String HeaderDataValue;
        String dataValue;
        String emptyString = "";

        int firstPosition = 0;

        for (int position = firstPosition; position < getListDataHead().getLastCellNum(); position++) {

            HeaderDataValue = assignCellValueExcelFile(getListDataHead().getCell(position));
            dataValue = assignCellValueExcelFile(fila.getCell(position));

            if (!dataValue.isEmpty()) {
                AssignValueAttributesClass.setAttribute(datos, HeaderDataValue, dataValue);
            } else {
                AssignValueAttributesClass.setAttribute(datos, HeaderDataValue, emptyString);
            }
        }
    }

}
