## List vs Set vs Map
|  | List | Set | Map | 
| :------------: | :------------: | :------------: | :------------: | 
| **순서** | O | X | X |
| **데이터 중복** | O | X | key는 X, value는 O |
| **구현 클래스** | LinkedList <br> Stack <br> Vector <br> ArrayList | HashSet <br> TreeSet | HashMap <br> TreeMap <br> HashTable <br> Properties |

### List
* 순서가 있는 데이터의 집합
* 데이터 중복 허용

### Set
* 순서를 유지하지 않는 데이터의 집합
* 데이터의 중복 허용 X

### Map
* 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합
* 순서는 유지되지 않음
* 키는 중복을 허용하지 않으며 값의 중복을 허용

> 이 글은 https://hackersstudy.tistory.com/26 를 바탕으로 작성되었습니다.
