
$(function() {
  // List sorted by month
    const dataset = {
      labels: expenseList.map(row => row.aggDate),
      datasets: [
        {
          label: fixValue,
          data: expenseList.map(row => row.fixValue),
          borderColor: '#36A2EB',
          backgroundColor: '#36A2EB'
        },
        {
          label: varValue,
          data: expenseList.map(row => row.varValue),
          borderColor: '#8c0863',
          backgroundColor: '#8c0863'
        },
        {
            label: totalValue,
            data: expenseList.map(row => row.fixValue + row.varValue),
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