package com.offer.test;

/**
 * @author zhouwenchen
 * @Description: 枚举类实现单例模式
 * @date 2020/1/18 16:38
 */
public enum SingletonEnum {
    INSTANCE;
    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args){
        System.out.println("123");
        // 单例测试
        SingletonEnum firstSingleton = SingletonEnum.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());

        SingletonEnum secondSingleton = SingletonEnum.INSTANCE;
        secondSingleton.setObjName("secondName");

        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());

        // 反射获取实例
        try {
            SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
            for (SingletonEnum enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
