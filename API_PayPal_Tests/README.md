# Testy API – PayPal API

## Opis projektu

Projekt zawiera **automatyczne testy API dla PayPal**, napisane w **Javie** z wykorzystaniem **RestAssured** oraz **TestNG**.

Celem testów jest kompleksowa weryfikacja poprawności działania **PayPal API**, obejmująca zarówno scenariusze techniczne, jak i biznesowe. Testy sprawdzają komunikację HTTP, poprawność danych zwracanych przez API, obsługę autoryzacji oraz reakcję systemu na błędne dane wejściowe.

Projekt został zaprojektowany jako **stabilny zestaw testów regresyjnych**, możliwy do uruchamiania lokalnie oraz w środowiskach CI/CD.

---

## Zakres testów

Zakres testów obejmuje szeroki przekrój funkcjonalności PayPal API, w tym:

### Autoryzacja i bezpieczeństwo

* OAuth 2.0 – pobieranie i odświeżanie tokenów
* walidacja poprawnych i niepoprawnych danych uwierzytelniających
* testy braku autoryzacji i wygasłych tokenów
* weryfikacja nagłówków bezpieczeństwa

### Operacje transakcyjne

* tworzenie i obsługa zamówień
* realizacja płatności (capture / authorize)
* pobieranie szczegółów transakcji
* walidacja statusów biznesowych
* testy idempotencji

### Dane i kontrakt API

* walidacja struktury odpowiedzi JSON
* sprawdzanie wymaganych i opcjonalnych pól
* weryfikacja typów danych i formatów
* spójność danych pomiędzy endpointami

### Scenariusze negatywne

* niepoprawne dane wejściowe
* brak wymaganych pól
* nieobsługiwane operacje
* przekroczenia limitów i błędy serwera
* nieprawidłowe parametry zapytań

### Obsługa błędów

* walidacja kodów HTTP (4xx / 5xx)
* sprawdzanie komunikatów błędów API
* stabilność odpowiedzi przy błędach systemowych

---

## Technologie

Projekt wykorzystuje:

* **Java**
* **RestAssured** – komunikacja HTTP i walidacja odpowiedzi
* **TestNG** – zarządzanie testami, suite’y, grupy
* **Maven** – budowanie projektu i uruchamianie testów
* **Allure** – raportowanie wyników testów

---

## Uruchamianie testów

### Uruchomienie wszystkich testów

```bash
mvn test
```

### Uruchomienie przez `testng.xml`

```bash
mvn -DsuiteXmlFile=testng.xml test
```

Plik `testng.xml` pozwala na:

* definiowanie zestawów testów,
* kontrolę kolejności uruchamiania,
* logiczne grupowanie scenariuszy.

### Uruchomienie wybranych testów

```bash
mvn -Dtest=OrdersTest test
```

---

## Raportowanie – Allure

Projekt jest zintegrowany z **Allure Report**, który zapewnia:

* czytelny status testów (PASS / FAIL / SKIP),
* szczegóły błędów i asercji,
* czasy wykonania testów.

Generowanie raportu:

```bash
mvn allure:serve
```

---

## Konfiguracja środowiska

Testy korzystają z **PayPal Sandbox**.

Dane konfiguracyjne:

* `CLIENT_ID`
* `CLIENT_SECRET`
* adres bazowy API

Klucze i dane wrażliwe:

* nie są przechowywane w repozytorium,
* przekazywane są przez zmienne środowiskowe lub parametry Mavena.

---

## Dobre praktyki

* brak hardkodowanych danych testowych
* czytelne i jednoznaczne asercje
* pełne pokrycie scenariuszy pozytywnych i negatywnych
* stabilne testy regresyjne
* czytelne raportowanie błędów

---

## Przeznaczenie projektu

Projekt może być wykorzystywany jako:

* zestaw **testów regresyjnych PayPal API**,
* wsparcie testów integracyjnych,
* przykład zaawansowanych testów REST w Javie,
* projekt portfolio QA Automation.
