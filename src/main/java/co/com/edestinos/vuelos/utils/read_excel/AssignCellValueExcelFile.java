package co.com.edestinos.vuelos.utils.read_excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;

import static co.com.edestinos.vuelos.utils.static_information.StaticInformation.EXCEPTION_CONSTRUCTOR_EMPTY;

public class AssignCellValueExcelFile {

    private AssignCellValueExcelFile() {
        throw new IllegalStateException(EXCEPTION_CONSTRUCTOR_EMPTY);
    }

    public static String assignCellValueExcelFile(Cell cell) {
        String contieneE = "E";
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                if (String.valueOf(cell.getNumericCellValue()).contains(contieneE)) {
                    return String.format("%.0f", cell.getNumericCellValue());
                } else {

                    return validarSiEsUnValorEntero(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return ((XSSFCell) cell).getRawValue();
            default:
                return cell.getStringCellValue();

        }
    }

    private static String validarSiEsUnValorEntero(double datoValorCelda) {
        if ((datoValorCelda - (int) datoValorCelda) > 0) {
            return String.valueOf(datoValorCelda);
        } else {
            return String.valueOf((int) datoValorCelda);
        }

    }

}
