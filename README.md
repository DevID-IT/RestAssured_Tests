

## 📦 RestAssured_Tests

Repozytorium pełni rolę **kontenera (hubu)** dla **niezależnych projektów automatycznych testów API**.
Każde API posiada **oddzielny folder**, własną konfigurację oraz zestaw testów.

Testy wykonywane są wyłącznie na **środowiskach testowych (sandbox)**.

---

## 📁 Struktura repozytorium

```
api-tests/
 ├── API_Stripe_Tests/
 ├── API_PayPal_Tests/
 └── README.md
```

Każdy podfolder jest **samodzielnym projektem testowym**.

---

## 🧪 Co zawierają projekty API

Każdy projekt:

* posiada własny `pom.xml`
* ma niezależną konfigurację środowiska
* zawiera testy REST API
* korzysta z tego samego standardu struktury

---

## 🛠️ Technologie (wspólne dla projektów)

* **Java**
* **Rest Assured**
* **TestNG**
* **POJO**
* **Allure Report**
* **Maven**

---

## 🎯 Cel repozytorium

* jedno miejsce na różne projekty testów API
* pełna separacja dostawców i integracji
* łatwe dodawanie kolejnych API
* spójny standard automatyzacji testów

---

## ➕ Dodawanie nowego API

1. Utwórz nowy folder na poziomie root
2. Skopiuj standardową strukturę projektu
3. Dodaj dedykowane README dla danego API
4. Skonfiguruj dostęp do środowiska testowego

---

## ⚠️ Informacje

* testy przeznaczone wyłącznie do celów edukacyjnych i testowych
* dane dostępowe nie są wersjonowane
* każde API uruchamiane jest niezależnie

