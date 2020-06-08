# Clean Mvvm
mvvm cleanarchitecture koin livedata viewmodel

아키텍쳐 그림판.

### 2020.05.20
프로젝트 생성 및 오픈소스 분석.

### 2020.05.28
BaseFragment 추가.
ViewModel -> View 데이터 Generic 으로 변경.  


### 2020.06.08
1)Live데이터를 Repository까지?  (CleanArchitecture 에서 Domain 은 LiveData 적용X, Rx나 그외 이용.)
https://www.reddit.com/r/androiddev/comments/8pgjt2/clean_architecture_and_livedata_is_it_possible/

2)Domain 적용 여부?
확장성, 비지니스로직 파악에 매우 좋으며, 행위가 명시적이여서 앱의 큰 틀을 보기 쉽다.
적용 여부는 확장의 빈도, 재사용여부에 따라 결정, 팀원들이 편리성에 대해서 결정 하는 것이 좋다.
https://proandroiddev.com/why-you-need-use-cases-interactors-142e8a6fe576