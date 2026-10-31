# Retrofit Demo (Grupo 2)

App Android en Java que consume `GET https://jsonplaceholder.typicode.com/posts` con Retrofit
y muestra los posts en un RecyclerView.

Abre la pantalla y muestra “Cargando...”.
Pide los datos a internet. Retrofit hace una petición a jsonplaceholder.typicode.com/posts, que es una página de prueba que da datos falsos.
El servidor responde con 100 posts en formato JSON, que es texto ordenado con título y contenido.
Convierte ese texto en objetos. Gson toma el JSON y crea un objeto Post por cada uno, con su id, título y cuerpo.
Los muestra en la lista. El adaptador pone cada post en una fila del RecyclerView, y arriba aparece “Posts recibidos: 100”.
Si falla algo, por ejemplo no hay internet, muestra el error y un botón “Reintentar”.

## Archivos principales
- Post.java: clase POJO del JSON.
- ApiService.java: endpoints (@GET, @POST, @PUT, @PATCH, @DELETE, @Path, @Query, @Body).
- RetrofitClient.java: configuración de Retrofit (baseUrl + Gson).
- MainActivity.java: llamada asíncrona con enqueue(), onResponse y onFailure.
- PostAdapter.java + layouts XML: presentación de los datos.


Apaga el internet del emulador y reinicia la app: se muestra el mensaje de onFailure y el botón Reintentar.
