const axios = require('axios');

const clientId = '****';
const clientSecret = '*****';

const encodedCredentials = Buffer.from(`${clientId}:${clientSecret}`).toString('base64');

const getToken = async () => {
  try {
    const response = await axios.post('https://accounts.spotify.com/api/token', null, {
      headers: {
        'Authorization': `Basic ${encodedCredentials}`,
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      params: {
        grant_type: 'client_credentials',
      },
    });

    console.log('Access Token:', response.data.access_token);
  } catch (error) {
    console.error('Error:', error.response?.data || error.message);
  }
};

getToken();
