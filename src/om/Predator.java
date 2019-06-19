package om;

public class Predator extends Animal {

	public Predator(int id, String name, double weight) {
		super(id, name, weight);
	}
	public void eat(Food food) throws Exception{
		//���� ����� ������ ����� �����
		if (!this.isAlive()) 
			throw new IllegalStateException("Only living animals can eat");
			// ������ ��� ������ ����������
		if ( !(food instanceof Herbivore))
			throw new IllegalArgumentException("Predator can eat only herbivores");
		
		Herbivore h = (Herbivore)food;	//Food object casted to a proper class
		
		//������ �������, ��� ����� ����������. ���������� �����...
		if(!huntSuccess()){
			// ������ �������
			System.out.println("The prey, glorious "+h.getName()+", was lucky enough to run away.");
			return;
		}
		//������ �������
		System.out.println("The "+this.getName()+" was lucky enough to hunt down that "+h.getName()+".");
		h.die();	//������ �������
		
		this.setWeight(this.getWeight() + h.getWeight()); 	// ����������� ��� �������� ��
															// �������� ���� �����������
		System.out.println(h.getWeight()+" killograms of flesh was successfully eaten");
		h.setWeight(0);	//�������� ���� ������� ���������
		
	}

	private boolean huntSuccess(){
		return (Math.random() > 0.7);
	}
}
