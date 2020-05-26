using Methodica_Exams.Model;
using Methodica_Exams.Services;
using Methodica_Exams.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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
    /// Lógica de interacción para Examen.xaml
    /// </summary>
    public partial class Examen : Window
    {
        public alumnos AlumnoLogueado { get; set; }
        public Examen(examenes examen, alumnos alumnoLogueado)
        {
            InitializeComponent();
            this.DataContext = new ExamenVM(examen,alumnoLogueado);
            AlumnoLogueado = alumnoLogueado;
        }

        private void EnviarExamenButton_Click(object sender, RoutedEventArgs e)
        {

            // Para cada pregunta del examen encuentra su TextBox correspondiente donde se aloja la respuesta y de esta forma añadirla a su lista de respuestas
            foreach (preguntas p in (this.DataContext as ExamenVM).Examen.preguntas)
            {
                string tagName = p.id.ToString();
                IEnumerable<TextBox> elements = FindVisualChildren<TextBox>(this).Where(x => x.Tag != null && x.Tag.ToString() == tagName);

                string textoRespuesta = elements.First().Text;

                (this.DataContext as ExamenVM).GuardarRespuesta(textoRespuesta,p);
            }            
            Close();
            
        }

        public static IEnumerable<T> FindVisualChildren<T>(DependencyObject depObj) where T : DependencyObject
        {
            if (depObj != null)
            {
                for (int i = 0; i < VisualTreeHelper.GetChildrenCount(depObj); i++)
                {
                    DependencyObject child = VisualTreeHelper.GetChild(depObj, i);
                    if (child != null && child is T)
                    {
                        yield return (T)child;
                    }

                    foreach (T childOfChild in FindVisualChildren<T>(child))
                    {
                        yield return childOfChild;
                    }
                }
            }
        }
    }
}
