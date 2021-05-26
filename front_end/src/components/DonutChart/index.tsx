import axios from 'axios';
import Chart from 'react-apexcharts';
import { BASE_URL } from 'utills/requests';
import { SaleSum } from 'types/sales';
import { useEffect, useState } from 'react';

type ChartData = {
    labels: string[];
    series: number[];
}
const DonutChart = () => {
    //Para sicronizar, forma correta
    //userState serve para manter o estado
    //useEffect para parar loop infinito executar ou destruir componente
    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    //Ciclo de vida diferente, necessita de sicronização com javascript
    //Forma errada
    //let chartData: ChartData ={ labels: [], series: []};
    //Certodo
    useEffect(() => {
        // eslint-disable-next-line no-template-curly-in-string
        axios.get(BASE_URL + "/sales/amount-by-seller")
            .then(response => {
                const data = response.data as SaleSum[];
                const myLabels = data.map(x => x.sellerName);
                const mySeries = data.map(x => x.sum);
                //Errado modo
                //chartData={ labels: myLabels, series:mySeries};
                //Certo
                setChartData({ labels: myLabels, series: mySeries });
            });
    }, [])

    //const mockData = {
    //     series: [477138, 499928, 444867, 220426, 473088],
    //     labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    // }

    const options = {
        legend: {
            show: true
        }
    }
    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="200"

        />
    );
}

export default DonutChart;