package club.zhuangbinan.handle96p;

import java.math.BigDecimal;

public class Handle96Main {

    public static void main(String[] args) {

        OneDay96Point oneDay96Point = new OneDay96Point();
        oneDay96Point.setP1(BigDecimal.ONE);
        oneDay96Point.setP10(BigDecimal.TEN);
        oneDay96Point.setP13(BigDecimal.valueOf(13));

        Handle96PointUtil.setFieldValueByName(oneDay96Point,"p15",BigDecimal.valueOf(15),OneDay96Point.class);

        System.out.println(oneDay96Point);

    }

}
