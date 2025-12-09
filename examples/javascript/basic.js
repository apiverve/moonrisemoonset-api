/**
 * Moonrise Moonset API - Basic Usage Example
 *
 * This example demonstrates the basic usage of the Moonrise Moonset API.
 * API Documentation: https://docs.apiverve.com/ref/moonrisemoonset
 */

const API_KEY = process.env.APIVERVE_API_KEY || 'YOUR_API_KEY_HERE';
const API_URL = 'https://api.apiverve.com/v1/moonrisemoonset';

/**
 * Make a GET request to the Moonrise Moonset API
 */
async function callMoonriseMoonsetAPI() {
  try {
    // Query parameters
    const params &#x3D; new URLSearchParams({
            lat: 37.7749,
            lon: -122.4194,
            date: &#x27;12-02-2025&#x27;
        });

    const response = await fetch(`${API_URL}?${params}`, {
      method: 'GET',
      headers: {
        'x-api-key': API_KEY
      }
    });

    // Check if response is successful
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();

    // Check API response status
    if (data.status === 'ok') {
      console.log('✓ Success!');
      console.log('Response data:', data.data);
      return data.data;
    } else {
      console.error('✗ API Error:', data.error || 'Unknown error');
      return null;
    }

  } catch (error) {
    console.error('✗ Request failed:', error.message);
    return null;
  }
}

// Run the example
callMoonriseMoonsetAPI()
  .then(result => {
    if (result) {
      console.log('\n📊 Final Result:');
      console.log(JSON.stringify(result, null, 2));
    }
  });
