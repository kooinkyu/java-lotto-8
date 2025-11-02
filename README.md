# java-lotto-precourse
## 🧱 구현 기능 목록

### 로또 발행 기능
- [x] 구입 금액 입력 및 예외 처리 (`LottoService`)
- [x] 구입 금액에 따른 로또 장 수 계산 (`LottoService`)
- [x] 1~45 사이의 번호 유효성 검증 (`LottoNumber`)
- [x] 6개 번호 유효성 검증 및 중복 검사 (`Lotto`)
- [x] 1~45 사이의 6개 숫자 랜덤 생성 (`LottoGenerator`)
- [x] 발행된 로또 번호 출력 (`OutputView`, `Application`)

### 당첨 번호 입력 기능
- [x] 당첨 번호 입력 (쉼표 기준 분리)
- [x] 보너스 번호 입력
- [x] 입력값 유효성 검증 (1~45, 중복 불가) (`WinningLotto`)

### 당첨 결과 계산 기능
- [x] 각 로또의 당첨 번호 개수 계산 (`WinningLotto`)
- [x] 보너스 번호 일치 여부 판단 (`WinningLotto`)
- [x] Rank Enum을 통해 등수 및 상금 매핑 (`Rank`)
- [x] 당첨 통계 및 총 상금 계산 (`LottoResult`)

### 수익률 계산 기능
- [x] 총 상금 / 총 구입 금액 × 100 (`ProfitCalculator`)
- [x] 소수 둘째 자리 반올림 처리
- [x] “총 수익률은 XX.X%입니다.” 출력 (`Application`)

### 예외 처리
- [x] 금액/번호/보너스 입력 오류 시 예외 발생 (`LottoService`, `InputView`, `WinningLotto`)
- [x] `[ERROR]`로 시작하는 메시지 출력 및 재입력 요청 (`Application`, `OutputView`)

---
🧩 구현 구조

| 클래스명               | 주요 메서드                                         | 기능            | 설명                                      |
| ------------------ | ---------------------------------------------- | ------------- | --------------------------------------- |
| `Lotto`            | `validate()`, `getNumbers()`                   | 로또 번호 검증 및 반환 | 6개 번호 검증(1~45, 중복 불가) 후 정렬              |
| `LottoGenerator`   | `generate()`                                   | 랜덤 로또 생성      | `Randoms.pickUniqueNumbersInRange()` 사용 |
| `WinningLotto`     | `match(Lotto lotto)`                           | 당첨 결과 비교      | 입력 로또와 당첨 번호/보너스 번호 비교                  |
| `LottoResult`      | `getResultMap()`, `getTotalReward()`           | 당첨 통계 계산      | 등수별 로또 개수 및 총 상금 계산                     |
| `ProfitCalculator` | `calculateProfitRate()`                        | 수익률 계산        | 총 수익률을 소수점 둘째 자리 반올림                    |
| `LottoService`     | `purchaseLottos()`, `validateAmount()`         | 로또 발행 및 금액 검증 | 금액 입력 유효성 및 로또 생성 처리                    |
| `InputView`        | `readPurchaseAmount()`, `readWinningNumbers()` | 사용자 입력 처리     | 구입 금액, 당첨 번호, 보너스 번호 입력                 |
| `OutputView`       | `printPurchasedLottos()`, `printResult()`      | 결과 출력         | 구매 로또, 통계, 수익률 출력                       |
| `Application`      | `main()`                                       | 전체 실행 흐름 제어   | 프로그램 진입점, 전체 로직 실행                      |

---

🐞 Issue

| 이슈 번호 | 원인                                       | 해결 방법                                                                                                          |
| ----- | ---------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| #1    | `LottoTest` 실행 시 `AssertionError` 발생     | `Collections.sort()` 제거로 인해 번호 순서가 섞였던 문제. 번호 정렬 로직 복원으로 해결                                                    |
| #2    | `cannot find symbol: class Lotto` 컴파일 에러 | `Lotto` 클래스가 `domain` 패키지에 있어 `import` 누락 발생. 루트(`lotto`)로 이동 및 경로 수정                                          |
| #3    | `LottoTest` 중복 정의 충돌                     | `main` 하위에 존재하던 `LottoTest`(예제용)와 `test/java/lotto/domain/LottoTest`(실제 테스트) 간 충돌 발생. 예제 파일 삭제 및 import 정리로 해결 |
| #4    | 테스트 실패 시 한글 깨짐 (`濡쒕삉 踰덊샇??...`)          | Windows 콘솔 인코딩 문제. IntelliJ와 Git Bash 모두 `UTF-8`로 통일하여 해결                                                      |
