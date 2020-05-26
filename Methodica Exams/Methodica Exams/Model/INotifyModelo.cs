using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Methodica_Exams.Model
{
    public class INotifyModelo
    {

        public partial class usuarios : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
        }
        public partial class profesores : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
        }

        public partial class alumnos : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
        }

        public partial class cursos : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
        }

        public partial class temas : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
        }

        public partial class examenes : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
        }

        public partial class notas : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
        }

        public partial class preguntas : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
        }
        public partial class respuestas : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
        }
    }
}
