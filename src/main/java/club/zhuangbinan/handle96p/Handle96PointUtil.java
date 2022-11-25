package club.zhuangbinan.handle96p;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

/**
 * 对一天96点进行处理的工具类
 *
 */
public class Handle96PointUtil {

    private Handle96PointUtil(){};
    /**
     * 96点和时分的转换
     * @param pN 1到96点
     * @return 1到96点对应的时间
     */
    public LocalTime getLocalTimeBy96Point(int pN) {
        if (!(1 <= pN && pN <= 96)) {
            throw new IllegalArgumentException("参数有误,参数为1到96的整数");
        }
        int totalMinute = (pN - 1) * 15;
        int hour = BigDecimal.valueOf(totalMinute).divide(BigDecimal.valueOf(60), 0, RoundingMode.DOWN).intValue();
        int minute = totalMinute % 60;
        return LocalTime.of(hour, minute);
    }

    /**
     * 通过属性名设置属性值
     * @param target 目标对象
     * @param fieldName 属性名
     * @param value 属性值
     * @param clazz 类的字节码
     */
    public static void setFieldValueByName(Object target, String fieldName, Object value, Class<?> clazz) {
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        String setter = "set" + firstLetter + fieldName.substring(1);
        Method method = null;
        try {
            method = target.getClass().getMethod(setter, clazz);
            method.invoke(target, value);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过属性名获取属性值
     * @param target 目标对象
     * @param fieldName 属性名
     * @return 属性值
     */
    public static Object getFiledValueByName(Object target, String fieldName) {
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        String getter = "get" + firstLetter + fieldName.substring(1);
        Method method = null;
        Object obj = null;
        try {
            method = target.getClass().getMethod(getter, null);
            obj = method.invoke(target);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }




}
