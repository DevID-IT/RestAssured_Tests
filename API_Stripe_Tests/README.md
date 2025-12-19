
# Testy API – Stripe

## Opis projektu

Projekt zawiera **automatyczne testy API** dla systemu **Stripe**, napisane w Javie.
Testy służą do weryfikacji poprawności działania endpointów REST (np. klienci, usuwanie, błędy API).

W projekcie skupiamy się na:

* testach pozytywnych i negatywnych API
* walidacji odpowiedzi JSON
* stabilnym i powtarzalnym uruchamianiu testów

---

## Technologie

Projekt wykorzystuje:

* **Java**
* **RestAssured** – wysyłanie zapytań HTTP i walidacja odpowiedzi API
* **TestNG** – framework testowy (testy, preconditions, grupy, suite’y)
* **Maven** – zarządzanie zależnościami i uruchamianie testów
* **Allure** – raportowanie wyników testów

---

## Struktura testów

* Testy API są zorganizowane w klasy testowe TestNG
* Endpointy i logika wywołań HTTP są wydzielone od testów
* Testy mogą korzystać z:

    * `@BeforeSuite` do przygotowania danych
    * grup TestNG
    * warunkowego pomijania testów (skip)

---

## Uruchamianie testów

### Uruchomienie całego suite

```bash
mvn test
```

### Uruchomienie testów z `testng.xml`

Plik `testng.xml` definiuje:

* zestaw testów
* kolejność uruchamiania
* klasy testowe

```bash
mvn -DsuiteXmlFile=testng.xml test
```

### Uruchamianie wybranych testów

```bash
mvn -Dtest=CustomerTest test
```

---

## Raportowanie – Allure

Projekt jest zintegrowany z **Allure**, który generuje czytelne raporty zawierające:

* status testów (PASS / FAIL / SKIP)
* czas wykonania
* szczegóły błędów i asercji

### Generowanie raportu

```bash
mvn allure:serve
```

---

## Konfiguracja środowiska

* Testy wymagają dostępu do API Stripe (tryb testowy)
* Klucze API nie są przechowywane w repozytorium
* Konfiguracja odbywa się przez:

    * zmienne środowiskowe
    * parametry Mavena

---

## Dobre praktyki

* Logika API oddzielona od testów
* Czytelne asercje odpowiedzi JSON
* Pomijanie testów zależnych od danych zamiast ich failowania
* Jednoznaczne raportowanie błędów

---

## Przeznaczenie projektu

Projekt może być używany jako:

* zestaw testów regresyjnych API
* wsparcie testów integracyjnych
* przykład implementacji testów API w RestAssured + TestNG

---

