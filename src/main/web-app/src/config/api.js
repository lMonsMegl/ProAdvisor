export default function(URL, method, data){
  let formData = new FormData();

  console.log("API JS")
  console.log(data);
  for (let field in data) {
    formData.append(field, data[field]);
  }

  const headers = new Headers();
  headers.append('Content-Type', 'application/json');

  const request =  new Request(URL, { method, credentials: 'include',body: formData });

  return fetch(request);
}

