import { Entity, PrimaryGeneratedColumn, Column } from "typeorm";

@Entity()
export class Question {
  @PrimaryGeneratedColumn()
  id!: number; // "!" diz que será atribuído

  @Column()
  text!: string;

  @Column()
  answer!: string;

  @Column()
  points!: number;
}
