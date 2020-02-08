package Implementations;

public class WrapperForRowAndColumn {
    private  Integer Row;
    private Integer Column;

    public WrapperForRowAndColumn(Integer row, Integer column) {
        Row = row;
        Column = column;
    }

    public Integer getRow() {
        return Row;
    }

    public void setRow(Integer row) {
        Row = row;
    }

    public Integer getColumn() {
        return Column;
    }

    public void setColumn(Integer column) {
        Column = column;
    }
}
