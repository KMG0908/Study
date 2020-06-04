# 객체를 직렬화해서 저장하기
http://redutan.github.io/2018/05/29/ddd-values-on-jpa 이 글을 참고했다. 하나의 컬럼에 json 형식으로 있으면 되서, 첫번째 방법으로 구현했다.

Character.java
```java
@Convert(converter = CharacterAdditionalConverter.class)
@Column(name = "character_more", nullable = true, length = 4000)
private Set<Additional> characterMore = new HashSet<>();
```

Additional.java
```java
@Embeddable
@Value
public class Additional implements Serializable {
    String key;
    String value;
	
    @JsonCreator
    public Additional(@JsonProperty("key") String key, @JsonProperty("value") String value) {
        this.key = key;
        this.value = value;
    }
}
```

CharacterAdditionalConverter.java
```java
@Converter
public class CharacterAdditionalConverter implements AttributeConverter<Set<Additional>, String> {
    private ObjectMapper om = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Set<Additional> attribute) {
        try {
            return om.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("error log...");
        }
    }

    @Override
    public Set<Additional> convertToEntityAttribute(String dbData) {
        try {
            return om.readValue(dbData, new TypeReference<Set<Additional>>() { });
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("error log...");
        }
    }
}
```

아직 이 부분만 구현하고 dto와 service를 설계하지 않아서 이걸로 되는지는 나중에 확인할 수 있을 것 같다...
> dto와 service 구현 후 스웨거로 테스트해봤는데 문제없이 DB에 들어간다...!!!

# @CreatedDate, @LastModifiedDate
LocalDateTime, ZonedDateTime 다 사용해봤는데 스웨거에서는 잘 나오는데 워크벤치로 확인해보니까 제대로 안 나오더라.  
뭐가 문제지 계속 찾아봤었는데 워크벤치에서만 그럴 뿐 get 해올 때도 스웨거에서만 그런 거 보니까 mysql 서버 타임존 설정 때문에 그런것 같다.
