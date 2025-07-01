





在对枚举做反序列化时，可以使用注解：`JsonCreator`

在对枚举做序列化时，可以使用注解：`JsonValue`

它们主要是处理枚举类，在序列化与反序列化时，使用属性值，比如：

```java
@Getter
public enum YesOrNoEnums {
    YES(1),
    NO(0),
    ;

    @EnumValue
    @JsonValue
    private final int code;

    YesOrNoEnums(int code) {
        this.code = code;
    }
}
```





问题：`JsonCreator` 注解还没有生效，有说还需要`@JsonProperty` 注解配合使用才能知道，但是试在枚举上面，似乎还是不行，不知道是哪里出了问题。