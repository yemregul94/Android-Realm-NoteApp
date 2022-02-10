# Realm İle Android Not Uygulaması
Bu uygulama kullanıcıya not ekleme, silme ve düzenleme imkanı sunan basit bir uygulamadır. Notların kaydını Realm Database üzerinde tutmaktadır, yapılan her değişiklik ve ekleme önce database üzerinde değişiklik yapıp sonra ekrana yansıtılır.

## Not Ekleme
Tüm notlar ve giriş alanları önce boşluk kontrolünden geçer daha sonra da işleme alınır. Metin girişine yazılan notlar "not ekle" butonuna basınca veri tabanına yazılır ve kullanıcıya toast mesajı ile bilgi verilir. Daha sonra "notları listele" butonu ile notlar listelenir.

<a href="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/1_note_add.png" target="_blank">
<img src="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/1_note_add.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/2_note_added.png" target="_blank">
<img src="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/2_note_added.png" width="200" style="max-width:100%;"></a>

## Not Listeleme ve Güncelleme
Notlar, Realm üzerinden alınarak listelenir. Bir notun üzerine basınca düzenleme ekranı açılır ve güncelleme sonrası veri tabanındaki değer değişir. Tekrar listeleme ekranına dönüldüğünde de yeni değer ekrana düşmüş olur.

<a href="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/3_note_list.png" target="_blank">
<img src="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/3_note_list.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/5_note_update.png" target="_blank">
<img src="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/5_note_update.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/6_note_update.png" target="_blank">
<img src="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/6_note_update.png" width="200" style="max-width:100%;"></a>


## Not Silme
Notlar yanlarındaki çarpı butonlarına basılarak silinebilir. Notlar önce veri tabanından silinir ve daha sonra bu değişiklik ekrana yansıtılır.

<a href="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/4_note_delete.pngg" target="_blank">
<img src="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/4_note_delete.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/delete_gif.gif" target="_blank">
<img src="https://github.com/yemregul94/Android-Realm-NoteApp/blob/main/screenshots/delete_gif.gif" width="200" style="max-width:100%;"></a>

