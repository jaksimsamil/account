
$(function() {
  // List sorted by month
    const dataset = {
      labels: expenseList.map(row => row.aggDate),
      datasets: [
        {
          label: fixAmt,
          data: expenseList.map(row => row.fixAmt),
          borderColor: '#36A2EB',
          backgroundColor: '#36A2EB'
        },
        {
          label: varAmt,
          data: expenseList.map(row => row.varAmt),
          borderColor: '#8c0863',
          backgroundColor: '#8c0863'
        },
        {
            label: totalAmt,
            data: expenseList.map(row => row.fixAmt + row.varAmt),
            borderColor: '#11b893',
            backgroundColor: '#11b893'
        }
      ]
    };
    new Chart( document.getElementById('accountChart'), {
            type: 'line',
            data: dataset,
            options: {
                responsive: true,
                    scales: {
                        y: {
                            min: 500000,
                            ticks: { stepSize: 500000}
                        }
                    }
                }
        });}
);