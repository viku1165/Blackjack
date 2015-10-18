# Peliohjeet

Pelissä pelataan Blackjackia jakajaa vastaan. Blackjackin säänistä näiden ojeiden lopussa. Peliä pelataan pääasiassa käyttöliittymän alalaidassa olevilla nappuloilla (komnetonappuloilla).

## Panoksen asettaminen

Pelin ja jokaisen käden alussa on asetettava panos, jonka on oltava nollaa suurempi kokonaisluku. Kirjota panos käyttöliittymän alalaidassa, komentonappuloiden yläpuolella olevaan tekstikenttään.

## Pelaaminen ja komennot

Pelaa peliä käyttäen alalaiden komentonappuloita. 

* **Ota kortti**: Ota lisäkortti
* **Passaa**: Älä ota korttia. Käsi on nyt valmis ja vuoro siirtyy jakajalle.
* **Tuplaa**: Tuplaa käden panos. Tämän jälkeen saat yhden lisäkortin, minkä jälkeen passaat ja vuoro siirtyy jakajalle. Käytettävissä vain käden ensimmäisenä valintana.
* **Splittaa**: Mikäli alkuperäinen kätesi on pari, voit jakaa ne kahteen eri käteen. Luo toisen käden samalla panoksella kuin alkuperäinen käsi ja jakaa kumpaankin käteen kortin.(jolloin kummassakin kädessä kaksi korttia) Tämän jälkeen peli jatkuu normaalisti, mutta ensimmäisen kätesi valmistumisen jälkeen ei tulekaan jakajan vuoro, vaan pelaat toisen kätesi. Splittaamisen jälkeen voit vielä tuplata kummankin käden ensimmäisellä vuorolla.

Mikäli olet tilanteessa, jossa ei tarvitse tehdä valintaa (esimerkiksi panoksen asettamisen jälkeen) pääset eteenpäin painamalla mitä tahansa nappulaa. Mikäli tulee valita toiminto, ei-käytettävissä olevien toimintojen nappulat eivät tee mitään.

## Käden päättyminen
Kun olet valmis, vuoro siirtyy jakajalle. Jakaja jakaa itselleen kortteja, kunnes hänen kätensä summa on 17 tai enemmän. Tämän jälkeen peli ratkaisee käden ja saat viestin voititko vai hävisitkö. Tämän jälkeen paina mitä tahansa nappulaa jatkaaksesi seuraavaan käteen.


# Blackjackin säännöt

Blackjackissa tavoitteena on saada kätensä yhteisarvo mahdollisimman lähelle 21:ä menemättä sen yli. Alussa jaetaan kaksi korttia, minkä jälkeen pelaaja ottaa yksi kerrallaan lisäkortteja, kunnes on käteensä tyytyväinen ja passaa (tai käden arvo menee yli 21:n). Pelaaja voi tehdä myös muita liikkeitä, jotka on selitetty ohjeiden puolella. Peliä pelataan jakajaa vastaan. Kun pelaaja on valmis, jakaa jakaja itselleen kortteja, kunnes hänen kätensä arvo on 17 tai enemmän. Pelin voittaa se, jonka käden arvo on lähempänä 21:ä. Mikäli pelaajalla tai jakajalla on yli 21, hän häviää. Mikäli molemmilla on sama summa tai molemmat ovat menneet yli, tuloksena on tasapeli, jossa pelaajan panos palautetaan. Mikäli pelaajalla on kahdella alkuperäisellä kortillaan 21 (siis ässä ja mikä tahansa 10 arvoinen kortti), hänellä on Blackjack, jolla voittaa kertoimella 1,5 (siis jos panos oli 2, pelaaja voittaa panoksensa lisäksi 3). Mikäli myös jakajalla on blackjack, kyseessä on tasapeli.

## Korttien arvot

* Korttien 2-10 arvo on niiden nimellisarvo
* Kuvakortit (11-13, J,Q,K) ovat arvoltan 10
* Ässä (A) voi olla arvoltaan 1 tai 11