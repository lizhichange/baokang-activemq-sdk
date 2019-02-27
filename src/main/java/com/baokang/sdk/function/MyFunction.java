package com.baokang.sdk.function;

@FunctionalInterface
public interface MyFunction<T, R> {

    R handler(T t1, T t2);
}

class MuFunc {
    public Long getAdd(Long x, Long y, MyFunction<Long, Long> myFunction) {
        return myFunction.handler(x, y);
    }

    public static void main(String[] args) {
        MuFunc func = new MuFunc();
        Long add = func.getAdd(1L, 3L, (t1, t2) -> t1 + t2);
        System.out.println(add);
    }

}

