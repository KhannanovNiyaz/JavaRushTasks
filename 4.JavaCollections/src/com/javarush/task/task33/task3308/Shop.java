package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
@XmlType(name = "shop")
public class Shop {
    @XmlElement
    public Goods goods;
    @XmlElement
    public int count = 12;
    @XmlElement
    public double profit = 123.4;
    @XmlAnyElement
    public String secretData[] = {"String1", "String2", "String3", "String4", "String5",};

    @XmlType(name = "goods")
    public static class Goods {
        @XmlAnyElement
        public List<String> names = Arrays.asList("S1", "S2");
    }
}

/*
2. В классе Shop должно быть создано поле goods типа Goods.
3. В классе Shop должно быть создано поле count типа int.
4. В классе Shop должно быть создано поле profit типа double.
5. В классе Shop должен быть создан массив строк secretData.
6. В классе Shop должен содержаться вложенный статический класс Goods.
7. В классе Shop.Goods должен быть создан список строк names.
8. Все поля класса Shop должны быть публичными.
9. Метод getClassName класса Solution должен возвращать класс Shop.
* */
