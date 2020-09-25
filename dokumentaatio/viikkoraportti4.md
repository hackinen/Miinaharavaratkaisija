# Viikkoraportti 4

## Eteneminen

Tällä viikolla aloitin testejen tekemisellä jo olemassa oleville metodeille, sekä luomalla apumetodeja ja niiden testejä tulevalle pelitilanteita simuloivalle algoritmille. Aloitin simulaatioalgoritmin luomisen, mutta en ehtinyt vielä saamaan sitä toimivaksi.

Ideana simulaatioalgorimissa on helppojen miinojen ratkaisemisen jälkeen käydä läpi listaa niistä avaamattomista ruuduista, jotka sijaitsevat jo avattujen ruutujen reunoilla (ohjelmakoodissa nimellä borderCell). Rekursiivinen metodi simulateMove kokeilee laittaa lipun avaamattomaan ruutuun mikäli se on sääntöjen mukaan laillista ja jatkaa eteenpäin niin pitkälle kuin mahdollista sääntöjen puitteissa. Vastaavasti jos lippua ei voida laittaa, koetetaan merkitä ruutu avatuksi ja jatketaan samaan tapaan rekursiivisesti eteenpäin. Mikäli aloitusruudulle löytyy yksi varma siirto (joko lippu tai avaaminen), tallennetaan tämä siirto oliomuuttujaan simulatedMove, joka sitten palautetaan kutsuvaan metodiin makeMove.

En tosiaan vielä deadlinen tullessa vastaan ehtinyt selvittämään, mikä simulaatiossa ei oikein toimi, sillä tällä hetkellä varmojen siirtojen loputtua näyttää siltä, että algoritmi vain arvaa seuraavan siirron tai jäätyy kokonaan eikä tee mitään siirtoa.

## Ajankäyttö

Tällä viikolla aikaa projektin parissa kului 18h.
