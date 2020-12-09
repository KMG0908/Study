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
    그 이후에 발생한 위의 오류는 아직 해결하지 못하였다.
