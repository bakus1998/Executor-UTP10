# UTP10

Korzystając z narzędzi programowania współbieżnego zawartych w pakiecie java.util.concurrent (m. in. z wykonawców - Executor, odbioru wyników zadań - Callable, FutureTask, ...) napisać program ilustrujący działanie zadań za pomocą wątków w puli.
Działanie każdego wątku polega na wylosowywaniu liczb naturalnych z podanego przedziału (np. [1, 100]) do momentu, kiedy ich suma przekroczy podany limit. Między kolejnymi losowaniami danego wątku należy zastosować opóźnienie czasowe (również losowe).



1. Każdy wątek jest kontrolowany za pomocą przycisku z pierwotnym napisem "T ...".

2. Kliknięcie w przycisk "Create new" dodaje do obszaru w dolnej części ekranu nowy przycisk odpowiadający za nowy wątek. 

3. Uruchomienie danego wątku następuje po kliknięciu w "swój" przycisk, po czym napis na przycisku zmienia się z "T ..." na "Suspend T ...", zaczyna się losowanie liczb i ich  sumowanie.

4. Kliknięcie "Suspend T ..." powoduje wstrzymanie działania wątku, napis na przycisku zmienia się z "Suspend T ..." na "Continue T ...".

5. Po kliknięciu "Continue T ..." następuje wznowienie działania (tego samego) wątku.

6. Po normalnym zakończeniu działania danego wątku (tj. po przekroczeniu limitu) pojawia się odpowiednia informacja w obszarze tekstowym ("Thread ...: Done!"), napis na przycisku tego wątku zmienia się na "T ... done!", przycisk ten stanie się niedostępny, po kilku sekundach następuje usuwanie przycisku z obszaru przycisków.

7. W dowolnym momencie po uruchomieniu danego wątku, kliknięcie w jego przycisk z jednoczesnym wciśnięciem klawisza 'C' powoduje anulowanie pracy tego wątku, pojawia się odpowiednia informacja w obszarze tekstowym ("Thread ...: Cancelled!"), napis na przycisku zmienia się na "T ... cancelled", przycisk ten stanie się wtedy niedostępny.

8. Do realizacji wstrzymywania i wznawiania wątków należy korzystać z schematu wait/notify.

9. Kliknięcie przycisku "Stop" powoduje natychmiastowe zakończenie działania wszystkich rozpoczętych, jednocześnie nie zakończonych i nie anulowanych wątków w puli, jednocześnie zmieni to napisy ich przycisków na "T ... done!" (wszystkie obecne przyciski staną się wtedy niedostępne).

10. Przetwarzanie tymczasowych wyników (oraz odbiór wyników końcowych) w trakcie działania wątków powinno odbywać się wyłącznie w obsłudze tych wątków/zadań. 
