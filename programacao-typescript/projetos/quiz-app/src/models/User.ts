import { Entity, PrimaryGeneratedColumn, Column } from "typeorm";

@Entity()
export class User {
  @PrimaryGeneratedColumn()
  id!: number; // "!" diz ao TypeScript que será atribuído pelo TypeORM

  @Column()
  name!: string;

  @Column()
  score!: number;
}
