# Viikkoraportti 3

Tällä viikolla huomattava osa ajasta kului checkstylen ja javadocin saattamiseen osaksi projektia, sillä gradlen kanssa tässä oli hieman ongelmia. Ongelmat kuitenkin ratkesivat ja nyt projektissa on käytössä checkstyle, javadoc sekä jacoco. Muuten tällä viikolla olen refaktoroinut ja korjannut koodiani, koodannut lisää, tehnyt testejä sekä dokumentaatiota. Tämänhetkinen testikattavuus on näkyvissä [testausdokumentissa](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/testausdokumentti.md). Testejä ei ole vielä kovin montaa, ja niitäkin tulen vielä parantelemaan ja tekemään lisää jatkossa.

Ohjelma on tällä viikolla edennyt niin, että nyt botti osaa helppojen lippujen laittamisen lisäksi avata kaikki avaamattomat ruudut jonkin jo avatun (eli numeroidun) ruudun ympäriltä, mikäli sitä ympäröiviin ruutuihin on merkitty oikea määrä lippuja. Tssä muodossa botti selviää jo varsin pitkälle hyvän pelilaudan osuessa kohdalle: pienimmässä kentässä botti saa jo pelin voitettuakin hyvällä tuurilla. Tämän jälkeen toteutettavat päättelyt ovatkin sitten haastavampia ja niissä tullaan todennäköisesti tarvitsemaan jonkinsorttista rekursiota. Ensi viikolla onkin tarkoitus alkaa pähkäilemään näitä hankalampia päättelyjä.




Aikaa tällä viikolla on tään mennessä kulunut 9h.
