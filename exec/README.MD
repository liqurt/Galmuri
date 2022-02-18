### 1.Github 클론 이후 빌드 및 배포할 수 있도록 정리한 문서

1) 사용한 JVM, 웹서버, WAS 제품 등의 종류와 설정값, 버전 기재

   ##### BakcEnd

   java : 1.8 (zulu-8)

   IDE 버전 : IntelliJ IDEA 2021.3.2(Ultimate Edition)

   Spring Boot 버전 : 2.4.5

   tomcat은 Spring Boot에 내장된 버전을 사용함.

   gradle 버전 : 7.1

   mysel 버전 :  8.0.27

2) 빌드시 사용되는 환경 변수 등의 주요 내용 상세 기재

   ##### BackEnd

   intelliJ IDE에서 생성한 gradle 프로젝트를 사용함. 따로 gradle에 대해서 설정한 것이 없음.

3) 배포 시 특이사항 기재

   ##### BackEnd 

   Jenkins를 사용하지 못해서 변경 사항이 생기면, gradle BootJar를 사용하여 Jar파일을 생성한 다음에, 직접 서버에서 프로세스를 중지하고, jar파일을 올려주어서 다시 실행하였음.

4) DB접속 정보 등 프로젝트에 활용되는 주요 계정 및 프로퍼티가 정의된 파일 목록 

   ##### BackEnd

   DB : 

   [application-database]: BackEnd/application-database.properties	"application-database.properties"
   
   S3 : 
   
   [application-s3.prope]: BackEnd/application-s3.properties	"application-s3.properties"
   
   

### 2. 프로젝트에서 사용하는 외부 서비스 정보를 정리한 문서

##### 	BackEnd

​	AWS의 

[EC2]: BackEnd/EC2서버생성과정.docx	"EC2"

와 amazon RDS와 S3를 사용하였음.

### 3. DB 덤프 파일 최신본

### 4. 시연 시나리오

