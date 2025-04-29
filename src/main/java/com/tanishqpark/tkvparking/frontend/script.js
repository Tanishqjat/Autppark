// script.js
document.getElementById('bookingForm').addEventListener('submit', async function (e) {
    e.preventDefault();

    const bookingData = {
        name: document.getElementById('name').value,
        carNumber: document.getElementById('carNumber').value,
        mobileNumber: document.getElementById('mobileNumber').value,
        arrivalTime: document.getElementById('arrivalTime').value,
        departureTime: document.getElementById('departureTime').value,
    };

    try {
        const response = await fetch('http://localhost:8080/api/parking-slots', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(bookingData),
        });

        if (response.ok) {
            const result = await response.text();
            document.getElementById('responseMessage').innerText = result;
        } else {
            throw new Error('Failed to book the parking slot. Please try again.');
        }
    } catch (error) {
        document.getElementById('responseMessage').innerText = error.message;
    }
});
