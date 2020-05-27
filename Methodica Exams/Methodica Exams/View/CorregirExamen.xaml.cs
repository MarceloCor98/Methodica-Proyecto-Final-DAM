using Methodica_Exams.Model;
using Methodica_Exams.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Methodica_Exams.View
{
    /// <summary>
    /// Lógica de interacción para CorregirExamen.xaml
    /// </summary>
    public partial class CorregirExamen : Window
    {
        public CorregirExamen(examenes examen, alumnos alumno)
        {
            InitializeComponent();
            this.DataContext = new CorregirExamenVM(examen,alumno);

        }

        private void CorregirExamenButton_Click(object sender, RoutedEventArgs e)
        {
            
            if ((this.DataContext as CorregirExamenVM).Nota.nota > (this.DataContext as CorregirExamenVM).NotaMaxima)
                MessageBox.Show("La nota final es mayor que la máxima", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            else
            {
                (this.DataContext as CorregirExamenVM).Corregir();
                Close();
            }
                
        }

        private void NotaRespuesta_TextChanged(object sender, TextChangedEventArgs e)
        {
            
            var bc = new BrushConverter();
            (sender as TextBox).BorderBrush = (Brush)bc.ConvertFrom("#593196");

            if ((sender as TextBox).Text != "")
            {
                if(Regex.IsMatch((sender as TextBox).Text, @"[a-zA-Z,]"))
                    (sender as TextBox).BorderBrush = Brushes.Red;
            }                
            else
            {
                long idPregunta = long.Parse(((sender as TextBox).Tag.ToString()));

                float puntuacion = (this.DataContext as CorregirExamenVM).PuntuacionDePregunta(idPregunta);

                if ((sender as TextBox).Text != "" && float.Parse((sender as TextBox).Text) > puntuacion)
                    (sender as TextBox).BorderBrush = Brushes.Red;
            }

            
        }

        private void CalcularNotaButton_Click(object sender, RoutedEventArgs e)
        {
            (this.DataContext as CorregirExamenVM).CalcularNota();
            NotaFinalTextBlock.DataContext = null;
            NotaFinalTextBlock.DataContext = this.DataContext as CorregirExamenVM;
            
        }
    }
}
