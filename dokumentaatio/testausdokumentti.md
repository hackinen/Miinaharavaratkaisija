# Testausdokumentti

Ohjelmaa on testattu automaattitestein JUnitilla sekä ohjelmoinnin aikana manuaalisesti omilla testeillä.

## Automaattitestaus

Tällä hetkellä olen testannut luokkiani MyBot ja BotLogic, joiden testikattavuus löytyy alla olevasta kuvasta. Muut testit ovat valmiita testejä, jotka ovat tulleet projektipohjan mukana eivätkä liity minun tekemääni ohjelmakoodiin tai testaukseen.

### Testauskattavuus

<img src="https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/misc/testikattavuus-vko5.png" width="750">


## Tehokkuustestaus

Testasin tehokkuutta vasta pienimmällä valmiilla pelikenttäkoolla (10x10), ja pelin ratkaisemiseen kului botilla aikaa:

| yritys | päästiinkö läpi | aika (s) |
|:------:|:----------:|:--------|
| 1. | kyllä | 0.0070 |
| 2. | kyllä | 0.0067 |
| 3. | kyllä | 0.0036 |
| 4. | kyllä | 0.0005 |
| 5. | kyllä | 0.0010 |
| 6. | kyllä | 0.0005 |
| 7. | kyllä | 0.0004 |
| 8. | kyllä | 0.0005 |
| 9. | kyllä | 0.0005 |
| 10. | kyllä | 0.0005 |
| | | 0.00212|
