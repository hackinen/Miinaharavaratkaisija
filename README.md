# Miinaharavaratkaisija

Miinaharavaratkaisija on Java-kielinen ohjelma, joka on toteutettu tietorakenteiden ja algoritmien ainepintojen harjotustyönä.


## Dokumentaatio

[Määrittelydokumentti](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/maarittelydokumentti.md)

[Toteutusdokumentti](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/toteutusdokumentti.md)

[Testausdokumentti](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/testausdokumentti.md)

[Käyttöohje](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/kaytto-ohje.md)

### Viikkoraportit
[Viikkoraportti 1](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/viikkoraportti1.md)

[Viikkoraportti 2](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/viikkoraportti2.md)

[Viikkoraportti 3](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/viikkoraportti3.md)

[Viikkoraportti 4](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/viikkoraportti4.md)

[Viikkoraportti 5](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/viikkoraportti5.md)

[Viikkoraportti 6](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/viikkoraportti6.md)

## Komentorivitoiminnot

Projektiin on määritelty javadoc, jacoco-testikattavuus sekä checkstyle.

### JavaDoc

JavaDoc generoidaan minesweeper-master -ohjelmaprojektikansiossa komennolla:

``` gradle javadoc ```

JavaDocia voi tarkastella avaamalla tiedoston _Miinaharavaratkaisija/minesweeper-master/build/docs/javadoc/index.html_.

### Testikattavuus

Jacocon generointi tapahtuu komennolla:

``` ./gradlew build ```

Testikattavuutta voi tarkastella tiedostosta _Miinaharavaratkaisija/minesweeper-master/build/reports/jacoco/test/html/index.html_.


### Checkstyle

Checkstylen tarkastaminen suoritetaan komennolla:

``` gradle check ```

mahdolliset checkstyle-virheet löytyvät tiedostosta _Miinaharavaratkaisija/minesweeper-master/build/reports/checkstyle/main.html_.
