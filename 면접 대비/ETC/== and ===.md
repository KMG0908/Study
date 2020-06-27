## Javascript ==과 === 차이점
### ==
* 동등 연산자
* 피연산자가 서로 다른 타입이면 타입을 강제로 변환하여 비교
``` javascript
0 == ''             // true
0 == '0'            // true
1 == true           // true
false == '0'        // true
null == undefined   // true
false == null       // false
false == undefined  // false
```

### ===
* 일치 연산자
``` javascript
0 === ''            // false
0 === false         // false
1 === true          // false
NaN === NaN         // false
null === undefined  // false
```

> 이 글은 http://guswnsxodlf.github.io/javascript-equal-operator 를 바탕으로 작성되었습니다.
