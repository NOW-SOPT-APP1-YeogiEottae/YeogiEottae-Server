## YeogiEottae-Server 🍀

### Back-end (Spring 🌱)
| <img src="https://avatars.githubusercontent.com/u/150939763?v=4" width=300px alt="서버/정정교"/>  | <img src="https://avatars.githubusercontent.com/u/63058347?v=4" width=300px alt="서버/신정윤"/>  | 
| :-----: | :-----: |
| [정정교/Junggyo1020](https://github.com/junggyo1020) | [신정윤/JungYoonShin](https://github.com/JungYoonShin) |

<br/>

## 📌 Commit Convention
### Commit 메세지
```text
[type/#이슈번호]: 작업내용

ex) [feat/#20]: 검색 결과 필터링 기능 추가
```
<br/>

### Branch 이름
```text
type/#이슈번호

ex) feat/#20
```
<br/>

### Branch 종류
| Type | 의미 |
| --- | --- |
| ✨ FEAT | 새로운 기능 추가 |
| 🔨 FIX | 버그, 오류 수정 |
| ✅ CHORE | 동작에 영향 없는 코드 or 변경 없는 변경사항(주석 추가 등)  ex) .gitIgnore |
| 📝 DOCS  | README나 WIKI 등의 문서 수정 |
| ♻️ REFACTOR | 코드 리팩토링 |
| ✏️ CORRECT  | 주로 문법의 오류나 타입의 변경, 이름 변경시 |
| ⚰️ DEL  | 쓸모없는 코드 삭제 |
| ⏪️ RENAME | 파일 이름 변경시 |
| 🔀 MERGE | 다른 브랜치와 병합 |
| 💡Test | 테스트 코드, 리팩토링 테스트 코드 추가  |
| ✒️ Comment | 필요한 주석 추가 및 변경 |
| 📂 File | 파일 또는 폴더명 수정, 이동, 삭제 등의 작업만 수행한 경우 |
| 🔥 !HOTFIX | 급하게 치명적인 버그를 고쳐야 하는 경우 |

<br/>

## 📂 Structure
```text
├── build.gradle
├── 📂 src/main/java/org/joinseminar
│       ├── 📂 domain
│       │       ├── 📂 entity1
│       │       │       ├── 📂 controller
│       │       │       ├── 📂 dto
│       │       │            ├── 📂 request
│       │       │            └── 📂 response
│       │       │       ├── 📂 model
│       │       │       ├── 📂 repository
│       │       │       └── 📂 service
│       │       └── 📂 entity2 
│       │               ├── 📂 controller
│       │               ├── 📂 dto
│       │                    ├── 📂 request
│       │                    └── 📂 response
│       │               ├── 📂 model
│       │               ├── 📂 repository
│       │               └── 📂 service
│       └── 📂 global
│               ├── 📂 common
│               │       ├── 📂 dto
│               │       └── 📂 model
│               ├── 📂 config
│               └── 📂 exception
│                       ├── 📂 enums
│                       ├── 📂 model(CustomException)
│                       └── GlobalExceptionHandler.java
└── ServerApplication.java
```
