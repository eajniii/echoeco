import axios from 'axios';

const fetchAuth = async fetchData => {
  const { method, url, data, header } = fetchData;

  try {
    const response =
      (method === 'get' && (await axios.get(url, header))) ||
      (method === 'post' && (await axios.post(url, data, header))) ||
      (method === 'put' && (await axios.put(url, data, header))) ||
      (method === 'delete' && (await axios.delete(url, header)));

    if (response && response.data.error) {
      // 요청이 수용됐으나 데이터 반환이 되지 않을 때
      console.log(response.data.error);
      alert('잘못된 로그인 정보입니다. 다시 시도해 주세요');
      return null;
    }

    if (!response) {
      //요청이 수용되지 않음
      alert('잘못된 요청입니다.');
      return null;
    }
    return response;
  } catch (err) {
    if (axios.isAxiosError(err)) {
      //서버 처리 오류
      const serverError = err;
      if (serverError && serverError.response) {
        console.log(serverError.response.data);
        return null;
      }
    }
    console.log(err);
    return null;
  }
};

const GET = (url, header) => {
  const response = fetchAuth({ method: 'get', url, header });
  return response;
};
const POST = (url, data, header) => {
  const response = fetchAuth({ method: 'post', url, data, header });
  return response;
};
const PUT = async (url, data, header) => {
  const response = fetchAuth({ method: 'put', url, data, header });
  return response;
};
const DELETE = async (url, header) => {
  const response = fetchAuth({ method: 'delete', url, header });
  return response;
};

export { GET, POST, PUT, DELETE };
