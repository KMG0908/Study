## CentOS 7에 ddd 설치하기
#### 1. http://springdale.math.ias.edu/data/puias/unsupported/7/SRPMS/ddd-3.3.12-20.sdl7.src.rpm 다운로드
#### 2. `rpm2cpio ddd-3.3.12-20.sdl7.src.rpm | cpio -idv`
#### 3. `tar -xf ddd-3.3.12.tar.gz`
#### 4. `cd ddd-3.3.12.tar.gz`
#### 5. `./configure --prefix=$HOME/ddd`
  * ```linux
    configure: error: You must set the environment variable CXX to a working 
                  C++ compiler.  Also check the CXXFLAGS settings.
                  See the file 'config.log' for further diagnostics.
    ```
    위와 같은 오류가 발생하였고 ```yum install gcc gcc-c++```로 해결하였다.
  * ```linux
    configure: error: Cannot find termcap compatible library.
    ```
    그 이후에 위와 같은 오류가 발생하였고 ```yum install ncurses-devel```로 해결하였다.
#### 6. `make`
  * ```linux
    make[2]: *** [strclass.o] 오류 1
    make[2]: Leaving directory `/home/ck0911.kim/ddd-3.3.12-20.sdl7.src/ddd-3.3.12/ddd'
    make[1]: *** [all] 오류 2
    make[1]: Leaving directory `/home/ck0911.kim/ddd-3.3.12-20.sdl7.src/ddd-3.3.12/ddd'
    make: *** [all-recursive] 오류 1
    ```
    위 오류를 해결하기 위해서 ```vi ddd/strclass.C```에서 include가 있는 부분에 ```#include <stdio.h>```를 추가하였다.
#### 7. `make install`
#### 8. `vi $HOME/.bashrc` 후 `export PATH=$PATH:$HOME/ddd/bin` 추가
#### 9. `source $HOME/.bashrc`
#### 8. `ddd`
  * ```Error: Can't open display:``` 오류가 뜨면서 실행이 안된다...  
    https://sourceforge.net/projects/xming/ xming 설치 후 xlaunch 실행시켜 다음-다음 계속 누르기  
    `vi /etc/ssh/sshd_config` 후 X11Forwarding과 X11UseLocalhost 주석 풀고 yes로 변경
    ![putty](https://1.bp.blogspot.com/-Xvyqf8xD9KQ/V6A2Isk2qjI/AAAAAAAAAiY/peAWXvcHO2YgkeOibRd4mW5mZhJX8s6qgCLcB/s1600/11.PNG)  
    putty > Connection > SSH > X11 > Enable X11 forwarding 체크, X display location "localhost:0" 입력  
    그리고 드디어 ddd를 실행시키는 데 성공했다!!!!!!
