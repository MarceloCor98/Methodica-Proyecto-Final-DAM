using Methodica_Exams.Model;
using Methodica_Exams.Services;
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
    /// Lógica de interacción para ConstruirExamenDialogo.xaml
    /// </summary>
    public partial class ConstruirExamenDialogo : Window
    {
        public ConstruirExamenDialogo(examenes examen)
        {
            InitializeComponent();
            this.DataContext = new ConstruirExamenVM(examen);
        }

        private void AceptarButton_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void AñadirPreguntaButton_Click(object sender, RoutedEventArgs e)
        {
            float puntuacion = (this.DataContext as ConstruirExamenVM).NuevaPregunta.puntuacion;

            if (TextoPreguntaTextBox.Text != "" && (float)(puntuacion) > 0f)
            {
                (this.DataContext as ConstruirExamenVM).AñadirPregunta();
                Refrescar();
            }
            else
                MessageBox.Show("No se han rellenado los campos correctamente", "Añadir pregunta", MessageBoxButton.OK,MessageBoxImage.Error);

        }

        private void EliminarPreguntaButton_Click(object sender, RoutedEventArgs e)
        {
            if ((this.DataContext as ConstruirExamenVM).PreguntaSeleccionada != null)
            {
                (this.DataContext as ConstruirExamenVM).EliminarPregunta();
                
                Refrescar();
            }
            else
            {
                MessageBox.Show("No hay ninguna pregunta seleccionada", "Eliminar pregunta", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }


        public void Refrescar()
        {
            PreguntasListBox.DataContext = null;
            PreguntasListBox.DataContext = this.DataContext;
        }
        
    }
}
